package com.example.informationSystem.controller;

import com.example.informationSystem.entity.DTO.ProjectDTO;
import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.entity.VO.ProjectVO;
import com.example.informationSystem.service.NoticeService;
import com.example.informationSystem.service.ProjectService;
import com.example.informationSystem.utils.FileUtils;
import com.example.informationSystem.utils.Pager;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/9/16 9:33
 */
@RestController
public class ProjectController {

    private final static String NOTICE_NAME = "审批失败通知";

    private final static String NOTICE_CONTENT = "感谢你的投递,欢迎下次光临。";

    private final static int PROJECT_SUBMIT = 1;

    private final static int ADMIN_SUBMIT_SUCCESS = 2;

    private final static int ADMIN_SUBMIT_FAILURE = 3;

    private final static int PRINCIPAL_SUBMIT_SUCCESS = 4;

    private final static int PRINCIPAL_SUBMIT_FAILURE = 5;

    private final static int CENTRALIZED_SUBMIT_SUCCESS = 6;

    private final static int CENTRALIZED_SUBMIT_FAILURE = 7;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private FileUtils fileUpload;

    /**
     * 文件上传
     * @param file 文件
     * @return 是否成功
     */
    @RequestMapping("/Build/Project/Insert")
    public Result addProject(ProjectVO projectVO, @RequestParam(name = "file",required = false) List<MultipartFile> file) throws IOException {

            if(file == null){

                return Result.error("文件未收到,系统异常");
            }

            List<String> pathList = fileUpload.upload(file);

            String userId = "123456";

            projectVO.setProjectUserId(userId);

        System.out.println(projectVO.getProjectCategoryId());

             if(projectService.addProject(projectVO, pathList)) {


                 return Result.success("项目创建成功");

             }

             return Result.error("创建项目失败");

     }

    @RequestMapping("/Build/Project/Id/Update")
    public Result updateProjectById(ProjectVO projectVO, @RequestParam(name = "file",required = false) List<MultipartFile> file) throws IOException {

        if(file == null){

            if(projectService.updateProject(projectVO)) {

                Result.success("项目修改成功");

            }else{

                Result.error("项目修改失败");

            }

        }else {

            List<String> pathList = fileUpload.upload(file);

            String userId = "123456";

            projectVO.setProjectUserId(userId);

            if (projectService.updateProject(projectVO, pathList)) {


                return Result.success("项目修改成功");

            }

            return Result.error("修改项目失败");

        }

        return Result.error("系统异常");

    }

    @RequestMapping("/Build/Project/Id/Delete")
    public Result deleteProjectById(List<String> projectIdList) {

        if(projectService.deleteProjectById(projectIdList)){

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

    @RequestMapping("/Build/Project/User/CreateStatus/Page/List")
    public Result selectProjectByUserIdAndCreateStatus(int createStatus,long currentPage, long pageSize){

        //token拿userId
        String userId = "123456";

        Pager<ProjectDTO> projectDtoPage = projectService.selectProjectDtoByUserIdAndCreateStatus(createStatus,userId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPage);

    }

    @RequestMapping("/Build/Project/User/ExecuteStatus/Page/List")
    public Result selectProjectByUserIdAndExecuteStatus(int executeStatus,long currentPage, long pageSize){

        //token拿userId
        String userId = "123456";

        Pager<ProjectDTO> projectDtoPage = projectService.selectProjectDtoByUserIdAndExecuteStatus(executeStatus,userId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPage);

    }

    @RequestMapping("/Build/Project/User/Page/List")
    public Result selectProjectByUserId(long currentPage, long pageSize){

        //token拿userId
        String userId = "123456";

        Pager<ProjectDTO> projectDtoPage = projectService.selectProjectDtoByUserId(userId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPage);

    }

    @RequestMapping("/Build/Project/Unit/AdminCreateStatus/Page/List")
    public Result selectProjectByUnitAndAdminCreateStatus(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByUnitAndCreateStatus(PROJECT_SUBMIT,unitId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping({"/Build/Project/Unit/PrincipalCreateStatus/Page/List","/Build/Project/Unit/AdminCreateStatusSuccess/Page/List"})
    public Result selectProjectByUnitAndPrincipalCreateStatus(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByUnitAndCreateStatus(ADMIN_SUBMIT_SUCCESS,unitId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping("/Build/Project/Unit/AdminCreateStatusFailure/Page/List")
    public Result selectProjectByUnitAndAdminCreateStatusFailure(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByUnitAndCreateStatus(ADMIN_SUBMIT_FAILURE,unitId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping("/Build/Project/Unit/PrincipalCreateStatusSuccess/Page/List")
    public Result selectProjectByUnitAndPrincipalCreateStatusSuccess(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByUnitAndCreateStatus(PRINCIPAL_SUBMIT_SUCCESS,unitId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping("/Build/Project/Unit/PrincipalCreateStatusFailure/Page/List")
    public Result selectProjectByUnitAndPrincipalCreateStatusFailure(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByUnitAndCreateStatus(PRINCIPAL_SUBMIT_FAILURE,unitId,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping({"/Centralized/Project/AdminCreateStatus/Page/List",})
    public Result selectProjectCentralizedAdminCreateStatus(long currentPage,long pageSize){

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByCreateStatusPage(PRINCIPAL_SUBMIT_SUCCESS,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping({"/Centralized/Project/AdminCreateStatusSuccess/Page/List",})
    public Result selectProjectCentralizedAdminCreateStatusSuccess(long currentPage,long pageSize){

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByCreateStatusPage(CENTRALIZED_SUBMIT_SUCCESS,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping({"/Centralized/Project/AdminCreateStatusFailure/Page/List",})
    public Result selectProjectCentralizedAdminCreateStatusFailure(long currentPage,long pageSize){

        Pager<ProjectDTO> projectDtoPager = projectService.selectProjectDtoByCreateStatusPage(CENTRALIZED_SUBMIT_FAILURE,currentPage,pageSize);

        return Result.success("查询成功",projectDtoPager);

    }

    @RequestMapping("/Build/Project/Id/ProjectSubmit/Update")
    public Result projectSubmitById(String projectId){

        if(projectService.updateProjectCreateStatusById(projectId,PROJECT_SUBMIT)){

            return Result.success("项目提交成功");

        }else{

            return Result.success("项目提交失败");

        }

    }

    @RequestMapping("/Build/Project/Id/AdminApprove/Update")
    public Result adminApproveById(String projectId){

        System.out.println(projectId);

        if(projectService.updateProjectCreateStatusById(projectId,ADMIN_SUBMIT_SUCCESS)){

            return Result.success("项目审批成功");

        }else{

            return Result.success("系统异常");

        }

    }

    @RequestMapping("/Build/Project/Id/AdminApproveFailure/Update")
    public Result adminApproveFailureById(String projectId){

        if(projectService.updateProjectCreateStatusById(projectId,ADMIN_SUBMIT_FAILURE)){

            String noticeName = "建设部门";

            String noticeContent = "你的项目在建设部门审批失败,请检查项目申请信息或材料,";

            if(addSystemNotice(noticeName + NOTICE_NAME,noticeContent + NOTICE_CONTENT,projectId)){

                return Result.success("项目审批失败,已发送邮件");

            }

            return Result.error("项目审批失败,发送失败");

        }else{

            return Result.success("系统异常");

        }

    }

    @RequestMapping("/Build/Project/Id/PrincipalApprove/Update")
    public Result principalApproveById(String projectId, String opinion){

        //token 拿用户id
        String userId = "123456";

        System.out.println(opinion);

        if(projectService.updateProjectCreateStatusById(projectId,PRINCIPAL_SUBMIT_SUCCESS)){

            if(projectService.setApprovalOpinion(projectId,userId,opinion)){

                return Result.success("项目审批成功");

            }

            return Result.success("意见填写失败");

        }else{

            return Result.success("系统异常");

        }

    }

    @RequestMapping("/Build/Project/Id/PrincipalApproveFailure/Update")
    public Result principalApproveFailureById(String projectId){

        if(projectService.updateProjectCreateStatusById(projectId,PRINCIPAL_SUBMIT_FAILURE)){

            String noticeName = "建设部门";

            String noticeContent = "你的项目在建设部门单位管理员审批失败,请修改完善申报任务书,";

            if(addSystemNotice(noticeName + NOTICE_NAME,noticeContent + NOTICE_CONTENT,projectId)){

                return Result.success("项目审批失败,已发送邮件");

            }

            return Result.error("项目审批失败,发送失败");

        }else{

            return Result.success("系统异常");

        }

    }

    @RequestMapping("/Centralized/Project/Id/AdminApprove/Update")
    public Result centralizedAdminApproveById(String projectId){

        if(projectService.updateProjectCreateStatusById(projectId,CENTRALIZED_SUBMIT_SUCCESS)){

            return Result.success("项目审批成功");

        }else{

            return Result.success("系统异常");

        }

    }

    /**
     * 审批失败系统发送邮件
     * @return 是否成功
     */
    private boolean addSystemNotice(String name,String content,String projectId){

        Notice notice = new Notice();

        notice.setNoticeId(String.valueOf(UUID.randomUUID()));

        notice.setNoticeName(name);

        notice.setNoticeContent(content);

        notice.setNoticePerson("系统");

        notice.setInformedPeople(projectService.getProjectUserIdByProjectId(projectId));

        notice.setCreationTime(LocalDateTime.now());

        return noticeService.addNotice(notice);

    }

    @RequestMapping("/Centralized/Project/Id/AdminApproveFailure/Update")
    public Result centralizedAdminApproveFailureById(String projectId){

        if(projectService.updateProjectCreateStatusById(projectId,CENTRALIZED_SUBMIT_FAILURE)){

            String noticeName = "归口部门";

            String noticeContent = "你的项目在归口部门审批失败,请减低预算相关实际需求,";

            if(addSystemNotice(noticeName + NOTICE_NAME,noticeContent + NOTICE_CONTENT,projectId)){

                return Result.success("项目审批失败,已发送邮件");

            }

            return Result.error("项目审批失败,发送失败");

        }else{

            return Result.success("系统异常");

        }

    }

    @RequestMapping("/Build/Project/CreateStatus/Update")
    public Result updateProjectCreateStatusById(String projectId,String createStatus){

        if(projectService.updateProjectCreateStatusById(projectId,Integer.parseInt(createStatus))){

            return Result.success("更新状态成功");

        }else{

            return Result.success("更新状态失败");

        }

    }

}
