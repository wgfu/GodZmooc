package Dao;

public interface ITestAndHomeworkDao {
	public <T> T getRuslt(T t);
	public <T> void updateT (T t);
	public <T> void deleteT (T t);
	public <T> void addT(T t);
}
