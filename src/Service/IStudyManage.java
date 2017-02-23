package Service;

import Entity.Study;

public interface IStudyManage {
	public Study getStudy(String userid);
	public void addStudy(Study study);
	public void deleteStudy(Study study);
	public void updateStudy(Study study);
}
