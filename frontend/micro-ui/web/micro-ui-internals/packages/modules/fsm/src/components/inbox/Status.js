import React, { useEffect, useState } from "react";
import { Loader } from "@egovernments/digit-ui-react-components";
import { useTranslation } from "react-i18next";
import StatusCount from "./StatusCount";

const Status = ({ onAssignmentChange, fsmfilters, mergedRoleDetails, statusMap }) => {
  const { t } = useTranslation();

  const { data: applicationsWithCount, isLoading } = Digit.Hooks.fsm.useApplicationStatus(true, true, statusMap);

  const [moreStatus, showMoreStatus] = useState(false);
  const [finalApplicationWithCount, setFinalApplicationWithCount] = useState([]);
  const [moreApplicationWithCount, setMoreApplicationWithCount] = useState([]);

  useEffect(() => {
    const finalApplication = mergedRoleDetails.statuses
      .map((roleDetails) => applicationsWithCount?.filter((application) => application.code === roleDetails)[0])
      .filter((status) => status?.code);

    const moreApplication = applicationsWithCount?.filter(
      (application) => !finalApplication.find((listedApplication) => listedApplication.code === application.code)
    );
    setFinalApplicationWithCount(finalApplication)
    setMoreApplicationWithCount(moreApplication)
  }, [applicationsWithCount]);

  useEffect(() => {
    if (statusMap && moreStatus) {
      const additionalFilters = ['WAITING_FOR_DISPOSAL', 'DISPOSED', 'CITIZEN_FEEDBACK_PENDING']
      if (!moreApplicationWithCount.find((ele) => additionalFilters.includes(ele.code))) {
        const additionalApplicationWithCount = statusMap?.filter((item) => additionalFilters.includes(item.applicationstatus)).map((state) => {
          return {
            name: t(`CS_COMMON_FSM_${state.applicationstatus}`),
            code: state.applicationstatus,
            id: state.statusid,
            roles: [],
          };
        })
        const moreApplication = moreApplicationWithCount.concat(additionalApplicationWithCount)
        setMoreApplicationWithCount(moreApplication)
      }
    }
  }, [moreStatus]);

  if (isLoading) {
    return <Loader />;
  }

  return finalApplicationWithCount?.length > 0 ? (
    <div className="status-container">
      <div className="filter-label">{t("ES_INBOX_STATUS")}</div>
      {finalApplicationWithCount?.map((option, index) => (
        <StatusCount key={index} onAssignmentChange={onAssignmentChange} status={option} fsmfilters={fsmfilters} statusMap={statusMap} />
      ))}
      {moreStatus
        ? moreApplicationWithCount?.map((option, index) => (
            <StatusCount key={index} onAssignmentChange={onAssignmentChange} status={option} fsmfilters={fsmfilters} statusMap={statusMap} />
          ))
        : null}
      {mergedRoleDetails.fixed === false ? (
        <div className="filter-button" onClick={() => showMoreStatus(!moreStatus)}>
          {" "}
          {moreStatus ? t("ES_COMMON_LESS") : t("ES_COMMON_MORE")}{" "}
        </div>
      ) : null}
    </div>
  ) : null;
};

export default Status;