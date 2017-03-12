package Service;

import java.util.List;

public interface ICommentPartManage {
public <T> List<?> getRuslt(T t);
public <T> void updateT (T t);
public <T> void deleteT (T t);
public <T> void addT(T t);

}
