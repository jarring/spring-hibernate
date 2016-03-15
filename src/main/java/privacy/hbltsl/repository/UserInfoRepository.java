package privacy.hbltsl.repository;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import privacy.hbltsl.model.UserInfo;

@Repository
public class UserInfoRepository {

	@Resource
	SessionFactory sessionFactory;

	public void replace(final List<UserInfo> list) throws Exception {

		if (list != null && !list.isEmpty()) {
			Session session = sessionFactory.getCurrentSession();
			Transaction trans = session.beginTransaction();
			try {
				for (UserInfo ui : list) {
					session.saveOrUpdate(ui);
					System.out.println(ui.getId());
				} 
				trans.commit();
			} catch (Exception e) {
				e.printStackTrace();
				trans.rollback();
			}
		}
	}

}
