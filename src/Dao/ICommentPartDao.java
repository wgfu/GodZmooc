package Dao;

import java.util.List;

public interface ICommentPartDao {
	public <T> List<?> getRuslt(T t);
	public <T> void updateT (T t);
	public <T> void deleteT (T t);
	public <T> void addT(T t);
}
