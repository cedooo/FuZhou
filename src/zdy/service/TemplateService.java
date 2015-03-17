package zdy.service;
/**
 * @MasterService  业务操作模板
 * @author zhangdengyuan
 * @createDate 2014-12-05
 * @lastUpdateDate 2014-12-05
 * @version 1.0
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TemplateService {
  /** 页面初始化 */
  public void init(HttpServletRequest request, HttpServletResponse response);
  /** 添加 */
  public void add(HttpServletRequest request, HttpServletResponse response);
  /** 逻辑删除 */
  public void delete(HttpServletRequest request, HttpServletResponse response);
  /** 物理删除 */
  public void remove(HttpServletRequest request, HttpServletResponse response);
  /** 更新 */
  public void update(HttpServletRequest request, HttpServletResponse response);
  /** 查询 */
  public void query(HttpServletRequest request, HttpServletResponse response);
  /** 更新页面查询 */
  public void updateAjax(HttpServletRequest request, HttpServletResponse response);
  /** excel报表导出 */
  public void exportExcel(HttpServletRequest request, HttpServletResponse response);
}
