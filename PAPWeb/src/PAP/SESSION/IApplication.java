package PAP.SESSION;

import java.util.List;

import PAP.MODEL.ObjectPAP;
import PAP.MODEL.UserPAP;


public interface IApplication {
	public boolean connect(String mail, String pass);
	public void subscribe(String name,String email,String pass,String city) throws Exception;
	public List<ObjectPAP> search(String name, String city);
	public void dropObject(ObjectPAP o);
	public void buyObject(String objectStringued);
	public Double calculateTurnover();
	//A supprimer pour la prod
	public String test();
	public List<ObjectPAP> getlistTest();
	public UserPAP getUserByMail(String mail);
}
