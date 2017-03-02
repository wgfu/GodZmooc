package Service;

import java.util.List;

import Entity.Study;

public interface IStudyManage {
	public List<?> getStudy(String userid);
	public void addStudy(Study study);
	public void deleteStudy(Study study);
	public void updateStudy(Study study);
}
