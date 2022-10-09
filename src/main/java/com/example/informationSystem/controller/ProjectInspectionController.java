package com.example.informationSystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.DTO.ProjectInspectionDTO;
import com.example.informationSystem.entity.Notice;
import com.example.informationSystem.entity.ProjectInspection;
import com.example.informationSystem.entity.VO.ProjectInspectionVO;
import com.example.informationSystem.service.NoticeService;
import com.example.informationSystem.service.ProjectFileService;
import com.example.informationSystem.service.ProjectInspectionService;
import com.example.informationSystem.service.ProjectService;
import com.example.informationSystem.utils.FileUtils;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author pcdn
 */
@RestController
public class ProjectInspectionController {

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
    private FileUtils fileUpload;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ProjectInspectionService projectInspectionService;

    @Autowired
    private ProjectFileService projectFileService;

    @RequestMapping("/Build/ProjectInspection/Insert")
    public Result addProjectInspection(ProjectInspectionVO projectInspectionVO,Integer type, @RequestParam(name = "file") MultipartFile file) throws IOException {

        if(file == null){

            return Result.error("错误，文件未收到");
        }

        String path = fileUpload.upload(file);

        //TODO 缓存拿id
        String userId = "123456";

        projectFileService.addProjectFile(path,type,projectInspectionVO.getProjectId());

        if(!projectInspectionService.isExistProjectInspectionByProjectId(projectInspectionVO.getProjectId())) {

            if (projectInspectionService.addProjectInspection(projectInspectionVO, userId)) {

                return Result.success("添加成功");

            } else {

                return Result.error("添加失败");

            }

        }

        return Result.success("操作成功");

    }

    @PostMapping("/Build/ProjectInspection/Id/Reset/Update")
    public Result updateProjectInspectionStatusToStart(List<String> projectInspectionIdList){

        for (String projectInspectionId : projectInspectionIdList) {

            projectInspectionService.updateProjectInspectionStatus(projectInspectionId, 0);

        }

        return Result.success("修改成功");

    }

    /**
     * 通过项目验收id修改项目
     * @param projectInspectionVO 项目验收扩展类
     * @param files 文件
     * @return 返回信息封装工具类
     * @throws IOException IO异常 文件异常
     */
    @RequestMapping("/Build/ProjectInspection/Id/Update")
    public Result updateProjectInspectionById(ProjectInspectionVO projectInspectionVO, @RequestParam(name = "file",required = false) List<MultipartFile> files) throws IOException {

        if(files == null){

                Result.error("文件为空");

        }else {

            List<String> pathList = fileUpload.upload(files);


            if (projectInspectionService.updateProjectInspection(projectInspectionVO.getProjectId(), pathList)) {


                return Result.success("项目验收报告修改成功");

            }

            return Result.error("修改项目验收报告失败");

        }

        return Result.error("系统异常");

    }

    /**
     * 批量删除项目
     * @param projectInspectionIdList 项目验收id数组
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Id/Delete")
    public Result deleteProjectInspectionById(List<String> projectInspectionIdList) {

        if(projectInspectionService.deleteProjectInspection(projectInspectionIdList)){

            return Result.success("删除成功");

        }

        return Result.error("删除失败");

    }

    /**
     * 通过项目负责人id创建状态分页查询项目DTO链表
     * @param status 状态
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/User/Status/Page/List")
    public Result selectProjectInspectionByUserIdAndCreateStatus(int status,long currentPage, long pageSize){

        //token拿userId
        String userId = "123456";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUserIdAndStatus(userId,currentPage,pageSize,status);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    @GetMapping("/Build/ProjectInspection/Project/One")
    public Result isExistProjectInspectionByProjectId(String projectId){

        if(projectInspectionService.isExistProjectInspectionByProjectId(projectId)){

            return Result.success("该项目,已存在项目验收报告");

        }else{

            return Result.error("该项目不存在项目验收报告");

        }

    }

    /**
     * 通过项目负责人id分页查询项目DTO链表
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/User/Page/List")
    public Result selectProjectInspectionByUserId(long currentPage, long pageSize){

        //token拿userId
        String userId = "123456";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUserId(userId,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 通过单位管理员通过单位id分页查询待审批项目DTO链表
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Unit/AdminStatus/Page/List")
    public Result selectProjectByUnitAndAdminCreateStatus(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUnitIdAndStatus(unitId,PROJECT_SUBMIT,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 单位管理员通过单位id分页查询审批成功项目DTO数组
     * 单位负责人通过单位id分页查询待审批项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping({"/Build/ProjectInspection/Unit/PrincipalStatus/Page/List","/Build/ProjectInspection/Unit/AdminCreateStatusSuccess/Page/List"})
    public Result selectProjectByUnitAndPrincipalCreateStatus(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUnitIdAndStatus(unitId,ADMIN_SUBMIT_SUCCESS,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 单位管理员通过单位id分页查询项目审批失败项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Unit/AdminStatusFailure/Page/List")
    public Result selectProjectByUnitAndAdminCreateStatusFailure(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUnitIdAndStatus(unitId,ADMIN_SUBMIT_FAILURE,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 单位负责人通过单位id分页查询审批成功项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Unit/PrincipalStatusSuccess/Page/List")
    public Result selectProjectByUnitAndPrincipalCreateStatusSuccess(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUnitIdAndStatus(unitId,PRINCIPAL_SUBMIT_SUCCESS,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 单位负责人通过单位id分页查询审批失败项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Unit/PrincipalStatusFailure/Page/List")
    public Result selectProjectByUnitAndPrincipalCreateStatusFailure(long currentPage,long pageSize){

        //token 那unitId
        String unitId = "1";

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByUnitIdAndStatus(unitId,PRINCIPAL_SUBMIT_FAILURE,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 归口管理员分页查询待审批项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping({"/Centralized/ProjectInspection/AdminStatus/Page/List",})
    public Result selectProjectCentralizedAdminCreateStatus(long currentPage,long pageSize){

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByStatus(PRINCIPAL_SUBMIT_SUCCESS,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 归口管理员分页查询审批成功项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping({"/Centralized/ProjectInspection/AdminStatusSuccess/Page/List",})
    public Result selectProjectCentralizedAdminCreateStatusSuccess(long currentPage,long pageSize){

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByStatus(CENTRALIZED_SUBMIT_SUCCESS,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 归口管理员分页查询审批失败项目DTO数组
     * @param currentPage 页数
     * @param pageSize 每页大小
     * @return 返回信息封装工具类
     */
    @RequestMapping({"/Centralized/ProjectInspection/AdminStatusFailure/Page/List",})
    public Result selectProjectCentralizedAdminCreateStatusFailure(long currentPage,long pageSize){

        IPage<ProjectInspectionDTO> projectInspectionDtoPage = projectInspectionService.selectProjectInspectionByStatus(CENTRALIZED_SUBMIT_FAILURE,currentPage,pageSize);

        return Result.success("查询成功",projectInspectionDtoPage);

    }

    /**
     * 项目负责人提交正式项目验收
     * @param projectInspectionId 项目id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Id/ProjectSubmit/Update")
    public Result projectInspectionSubmitById(String projectInspectionId){

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,PROJECT_SUBMIT)){

            return Result.success("项目验收提交成功");

        }else{

            return Result.success("项目验收提交失败");

        }

    }

    /**
     * 单位管理员审批通过项目
     * @param projectInspectionId 项目id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Id/AdminApprove/Update")
    public Result adminApproveById(String projectInspectionId){

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,ADMIN_SUBMIT_SUCCESS)){

            return Result.success("项目审批成功");

        }else{

            return Result.success("系统异常");

        }

    }

    /**
     * 单位管理员审批不通过
     * @param projectInspectionId 项目验收id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Id/AdminApproveFailure/Update")
    public Result adminApproveFailureById(String projectInspectionId){

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,ADMIN_SUBMIT_FAILURE)){

            String noticeName = "建设部门";

            String noticeContent = "你的项目在建设部门审批失败,请检查项目验收信息或材料,";

            if(addSystemNotice(noticeName + NOTICE_NAME,noticeContent + NOTICE_CONTENT,projectInspectionId)){

                return Result.success("项目审批失败,已发送邮件");

            }

            return Result.error("项目审批失败,发送失败");

        }else{

            return Result.success("系统异常");

        }

    }

    /**
     * 单位负责人审批通过项目
     * @param projectInspectionId 项目验收id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Id/PrincipalApprove/Update")
    public Result principalApproveById(String projectInspectionId, String opinion){

        //token 拿用户id
        String userId = "123456";

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,PRINCIPAL_SUBMIT_SUCCESS)){

            if(projectInspectionService.setApprovalOpinion(projectInspectionId,userId,opinion)){

                return Result.success("项目审批成功");

            }

            return Result.success("意见填写失败");

        }else{

            return Result.success("系统异常");

        }

    }

    /**
     * 单位负责人审批不通过项目
     * @param projectInspectionId 项目验收id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Build/ProjectInspection/Id/PrincipalApproveFailure/Update")
    public Result principalApproveFailureById(String projectInspectionId){

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,PRINCIPAL_SUBMIT_FAILURE)){

            String noticeName = "建设部门";

            String noticeContent = "你的项目在建设部门单位负责人审批失败,请修改完善项目验收报告,";

            if(addSystemNotice(noticeName + NOTICE_NAME,noticeContent + NOTICE_CONTENT,projectInspectionId)){

                return Result.success("项目审批失败,已发送邮件");

            }

            return Result.error("项目审批失败,发送失败");

        }else{

            return Result.success("系统异常");

        }

    }

    /**
     * 归口管理员审批通过项目
     * @param projectInspectionId 项目验收id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Centralized/ProjectInspection/Id/AdminApprove/Update")
    public Result centralizedAdminApproveById(String projectInspectionId){

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,CENTRALIZED_SUBMIT_SUCCESS)){

            ProjectInspection projectInspection = projectInspectionService.selectProjectInspectionById(projectInspectionId);

            //项目结题成功 修改执行状态为结题成功
            if(projectService.updateProjectExecuteStatusById(projectInspection.getProjectId(),3)) {

                return Result.success("项目审批成功");
            }


        }

        return Result.success("系统异常");

    }

    /**
     * 审批失败系统发送邮件
     * @return 是否成功
     */
    private boolean addSystemNotice(String name,String content,String projectInspectionId){

        Notice notice = new Notice();

        notice.setNoticeId(String.valueOf(UUID.randomUUID()));

        notice.setNoticeName(name);

        notice.setNoticeContent(content);

        notice.setNoticePerson("系统");

        notice.setInformedPeople(projectInspectionService.getUserIdById(projectInspectionId));

        notice.setCreationTime(LocalDateTime.now());

        return noticeService.addNotice(notice);

    }

    /**
     * 归口管理员审批不通过项目
     * @param projectInspectionId 项目验收id
     * @return 返回信息封装工具类
     */
    @RequestMapping("/Centralized/ProjectInspection/Id/AdminApproveFailure/Update")
    public Result centralizedAdminApproveFailureById(String projectInspectionId){

        if(projectInspectionService.updateProjectInspectionStatus(projectInspectionId,CENTRALIZED_SUBMIT_FAILURE)){

            String noticeName = "归口部门";

            String noticeContent = "你的项目在归口部门审批失败,请完善项目验收报告,";

            if(addSystemNotice(noticeName + NOTICE_NAME,noticeContent + NOTICE_CONTENT,projectInspectionId)){

                return Result.success("项目审批失败,已发送邮件");

            }

            return Result.error("项目审批失败,发送失败");

        }else{

            return Result.success("系统异常");

        }

    }

}
