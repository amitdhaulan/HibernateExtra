package hibernate.test;

import org.hibernate.Session;

public class Main {
	public static void main(String[] args) throws Exception {
		HibernateUtil hibernateUtil = new HibernateUtil();
		// hibernateUtil.executeSQLCommand("create table student (id int,name varchar);");

		Session session = hibernateUtil.getSession();

		Survey survey = new Survey();
		survey.setName("Amit");
		
		survey.setId(12345);
		System.out.println(survey.getId());

		session.save(survey);
//		session.flush();

		System.out.println(survey.getId());
		Survey surveyInSession = (Survey) session.get(Survey.class,
				survey.getId());
		System.out.println(surveyInSession.getName());

		session.close();
		hibernateUtil.checkData("select * from survey");
	}
}
