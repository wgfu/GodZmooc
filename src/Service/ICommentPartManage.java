package Service;

public interface ICommentPartManage {
public <T> T getRuslt(Class <T> t);
public <T> void updateT (Class <T> t);
public <T> void deleteT (Class <T> t);
public <T> void addT(Class <T> t);

}