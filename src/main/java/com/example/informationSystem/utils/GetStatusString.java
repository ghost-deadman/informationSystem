package com.example.informationSystem.utils;

public class GetStatusString {

    //项目申报状态
    private static final int PROJECT_DRAFT = 0;

    private static final int PROJECT_SUBMIT = 1;

    private static final int PROJECT_SUBMIT_SUCCESS = 2;

    private static final int PROJECT_SUBMIT_FAILURE = 3;

    private static final int PROJECT_APPROVE_SUCCESS = 4;

    private static final int PROJECT_APPROVE_FAILURE = 5;

    private static final int PROJECT_CENTRALIZED_SUCCESS = 6;

    private static final int PROJECT_CENTRALIZED_FAILURE = 7;

    private static final int PROJECT_REST_BACK = -1;

    //项目执行状态
    private static final int PROJECT_EXECUTE_CREATE = 0;

    private static final int PROJECT_EXECUTE_SUBMIT = 1;

    private static final int PROJECT_OVER_SUBMIT= 2;

    private static final int PROJECT_OVER_SUCCESS = 3;

    private static final int PROJECT_OVER_FAILURE = 4;

    private static final int PROJECT_EXECUTE_REST_BACK = -1;

    //项目预算表0：默认，1：申请中 ，2：申请成功，3：申请失败，4：审批成功，5：审批失败 6：待下拨 7：下拨中 8： 下拨完
    private static final int PROJECT_BUDGET_CREATE = 0;

    private static final int PROJECT_BUDGET_SUBMIT = 1;

    private static final int PROJECT_BUDGET_SUBMIT_SUCCESS = 2;

    private static final int PROJECT_BUDGET_SUBMIT_FAILURE = 3;

    private static final int PROJECT_BUDGET_APPROVE_SUCCESS = 4;

    private static final int PROJECT_BUDGET_APPROVE_FAILURE = 5;

    private static final int PROJECT_BUDGET_WAIT_MONEY = 6;

    private static final int PROJECT_BUDGET_GET_MONEY = 7;

    private static final int PROJECT_BUDGET_OVER_MONEY = 8;

    private static final int PROJECT_BUDGET_REST_BACK = -1;

    //项目验收0默认 1提交 2初审通过 3初审失败 4审批成功 5审批失败 6验收确认 7验收失败
    private static final int PROJECT_INSPECTION_DRAFT = 0;

    private static final int PROJECT_INSPECTION_SUBMIT = 1;

    private static final int PROJECT_INSPECTION_SUBMIT_SUCCESS = 2;

    private static final int PROJECT_INSPECTION_SUBMIT_FAILURE = 3;

    private static final int PROJECT_INSPECTION_APPROVE_SUCCESS = 4;

    private static final int PROJECT_INSPECTION_APPROVE_FAILURE = 5;

    private static final int PROJECT_INSPECTION_CENTRALIZED_SUCCESS = 6;

    private static final int PROJECT_INSPECTION_CENTRALIZED_FAILURE = 7;

    private static final int PROJECT_INSPECTION_REST_BACK = -1;


    public static String getCreateProjectStatus(int status){

         if(status == PROJECT_DRAFT){

             return "项目草稿生成";

         }else if(status == PROJECT_SUBMIT){

             return "项目正式提交";

         }else if(status == PROJECT_SUBMIT_SUCCESS){

             return "项目提交成功";

         }else if(status == PROJECT_SUBMIT_FAILURE){

             return "项目提交未通过";

         }else if(status == PROJECT_APPROVE_SUCCESS){

             return "项目初审通过";

         }else if(status == PROJECT_APPROVE_FAILURE){

            return "项目初审未通过";

         }else if(status == PROJECT_CENTRALIZED_SUCCESS){

             return "项目立项成功";

         }else if(status == PROJECT_CENTRALIZED_FAILURE){

             return "项目复审未通过";

         }else if(status == PROJECT_REST_BACK){

             return "项目被退回草稿";

         }

         return "错误 ,未知状态";

     }

    public static String getExecuteProjectStatus(int status){

        if(status == PROJECT_EXECUTE_CREATE){

            return "无 默认状态";

        }else if(status == PROJECT_EXECUTE_SUBMIT){

            return "项目进行中";

        }else if(status == PROJECT_OVER_SUBMIT){

            return "项目结题申请中";

        }else if(status == PROJECT_OVER_SUCCESS){

            return "项目结题成功";

        }else if(status == PROJECT_OVER_FAILURE){

            return "项目结题失败";

        }else if(status == PROJECT_EXECUTE_REST_BACK){

            return "项目退回进行中";

        }

        return "错误 ,未知状态";

    }

    public static String getProjectBudgetStatus(int status){

        if(status == PROJECT_BUDGET_CREATE){

            return "项目预算生成";

        }else if(status == PROJECT_BUDGET_SUBMIT){

            return "项目预算申请提交";

        }else if(status == PROJECT_BUDGET_SUBMIT_SUCCESS){

            return "项目预算申请初审通过";

        }else if(status == PROJECT_BUDGET_SUBMIT_FAILURE){

            return "项目预算申请初审不通过";

        }else if(status == PROJECT_BUDGET_APPROVE_SUCCESS){

            return "项目预算申请复审通过";

        }else if(status == PROJECT_BUDGET_APPROVE_FAILURE){

            return "项目预算申请复审不通过";

        }else if(status == PROJECT_BUDGET_WAIT_MONEY){

            return "项目预算待下拨";

        }else if(status == PROJECT_BUDGET_GET_MONEY){

            return "项目预算下拨中";

        }else if(status == PROJECT_BUDGET_OVER_MONEY){

            return "项目预算资金下拨完成";

        }else if(status == PROJECT_BUDGET_REST_BACK){

            return "项目资金预算退回草稿";

        }

        return "错误 ,未知状态";

    }

    public static String getProjectInspectionStatus(int status){

        if(status == PROJECT_INSPECTION_DRAFT){

            return "项目验收报告草稿生成";

        }else if(status == PROJECT_INSPECTION_SUBMIT){

            return "项目验收报告正式提交";

        }else if(status == PROJECT_INSPECTION_SUBMIT_SUCCESS){

            return "项目验收报告提交成功";

        }else if(status == PROJECT_INSPECTION_SUBMIT_FAILURE){

            return "项目验收报告提交未通过";

        }else if(status == PROJECT_INSPECTION_APPROVE_SUCCESS){

            return "项目验收报告初审通过";

        }else if(status == PROJECT_INSPECTION_APPROVE_FAILURE){

            return "项目验收报告初审未通过";

        }else if(status == PROJECT_INSPECTION_CENTRALIZED_SUCCESS){

            return "项目验收报告立项成功";

        }else if(status == PROJECT_INSPECTION_CENTRALIZED_FAILURE){

            return "项目验收报告复审未通过";

        }else if(status == PROJECT_INSPECTION_REST_BACK){

            return "项目验收报告退回草稿";

        }

        return "错误 ,未知状态";

    }


}
