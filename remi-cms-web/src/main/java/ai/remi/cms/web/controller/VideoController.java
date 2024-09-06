package ai.remi.cms.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import ai.remi.cms.domain.converter.VideoConverter;
import ai.remi.cms.domain.dto.post.VideoPostDTO;
import ai.remi.cms.domain.dto.put.VideoPutDTO;
import ai.remi.cms.domain.entity.Video;
import ai.remi.cms.domain.query.VideoQuery;
import ai.remi.cms.domain.vo.VideoVO;
import ai.remi.cms.server.service.VideoService;
import ai.remi.comm.core.result.PagerBean;
import ai.remi.comm.core.result.ResultBean;
import ai.remi.comm.domain.query.PageQuery;
import ai.remi.comm.util.bean.BeanCopyUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author DianJiu
 * @email dianjiuxyz@gmail.com
 * @desc 视频管理(Video)控制层
 */
@Validated
@RestController
@ApiSort(value = 1)
@Tag(name = "视频管理")
@RequestMapping("video")
public class VideoController {
    /**
     * 服务对象
     */
    @Resource
    private VideoService videoService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "查询单条")
    public ResultBean<VideoVO> get(@PathVariable @Validated @NotBlank(message = "ID不能为空") String id) {
        Video video = videoService.getById(id);
        //处理格式转换
        VideoVO videoVO = VideoConverter.INSTANT.entityToVO(video);
        return ResultBean.success(videoVO);
    }

    /**
     * 通过实体不为空的属性作为筛选条件查询对象列表
     *
     * @param videoQuery 实例对象
     * @return 对象列表
     */
    @PostMapping(value = "/list")
    @Operation(summary = "查询所有")
    public ResultBean<List<VideoVO>> list(@RequestBody VideoQuery videoQuery) {
        //处理格式转换
        Video video = VideoConverter.INSTANT.queryToEntity(videoQuery);
        //执行分页查询
        List<Video> listResult = videoService.list(new QueryWrapper<>(video));
        return ResultBean.success(BeanCopyUtils.coverList(listResult, VideoVO.class));
    }

    /**
     * 分页查询所有数据
     *
     * @param pageQuery  分页对象
     * @param videoQuery 查询实体
     * @return 分页对象
     */
    @PostMapping(value = "/page")
    @Operation(summary = "分页查询")
    public ResultBean<PagerBean<VideoVO>> page(PageQuery pageQuery, VideoQuery videoQuery) {
        //处理分页条件
        Page<Video> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        //处理格式转换
        Video video = VideoConverter.INSTANT.queryToEntity(videoQuery);
        //执行分页查询
        Page<Video> pageResult = videoService.page(page, new QueryWrapper<>(video));
        PagerBean<VideoVO> pageBean = new PagerBean<>(pageResult.getTotal(), pageResult.getCurrent(),
                pageResult.getSize(), BeanCopyUtils.coverList(pageResult.getRecords(), VideoVO.class));
        return ResultBean.success(pageBean);
    }

    /**
     * 新增数据
     *
     * @param videoDTO 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @Operation(summary = "新增数据")
    public ResultBean<Boolean> insert(@RequestBody @Validated VideoPostDTO videoDTO) {
        //处理格式转换
        Video video = VideoConverter.INSTANT.postDtoToEntity(videoDTO);
        //执行数据保存
        return ResultBean.success(videoService.save(video));
    }

    /**
     * 修改数据
     *
     * @param videoDTO 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @Operation(summary = "修改数据")
    public ResultBean<Boolean> update(@RequestBody @Validated VideoPutDTO videoDTO) {
        //处理格式转换
        Video video = VideoConverter.INSTANT.putDtoToEntity(videoDTO);
        //执行数据更新
        return ResultBean.success(videoService.updateById(video));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping("/delete")
    @Operation(summary = "删除数据")
    public ResultBean<Boolean> delete(@RequestParam("ids") List<String> ids) {
        return ResultBean.success(videoService.removeByIds(ids));
    }

}

