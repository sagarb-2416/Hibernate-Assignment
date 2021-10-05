package com.mini.project;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentManage {

	Scanner scanner = new Scanner(System.in);

	public void printAllStudentDetails() {
		EntityManagerFactory factory = null;

		EntityManager entityManager = null;

		try {
			factory = Persistence.createEntityManagerFactory("emp");

			entityManager = factory.createEntityManager();

			String findall = "from Student";

			Query query = entityManager.createQuery(findall);

			List<Student> list = query.getResultList();

			for (Student student : list) {

				System.out.println(student);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			entityManager.close();
			factory.close();

		}
	}

	public boolean findById() {
		System.out.println("enter the id");

		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {

			int id = scanner.nextInt();

			factory = Persistence.createEntityManagerFactory("emp");

			manager = factory.createEntityManager();

			String find_by_id = "from Student where id = :id";

			Query query = manager.createQuery(find_by_id);

			query.setParameter("id", id);

			Student student = (Student) query.getSingleResult();
		
			
			if (id==10000) {
				throw new IdNotFoundException();
				
			} 
			else {
				System.out.println(student);
				return true;
			}

		}
		catch (IdNotFoundException i) {
			// TODO: handle exception
			System.out.println(i.getMessage());
		}
		catch (Exception e) {
			
			// TODO: handle exception
			
		} finally {
			manager.close();
			factory.close();

		}
		return false;

	}

	public void Update() {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a id");
		try {
			int roll_no = sc.nextInt();
			factory = Persistence.createEntityManagerFactory("emp");

			manager = factory.createEntityManager();

			EntityTransaction transaction = manager.getTransaction();

			System.out.println("do toy want to update the name (y/n)");
			char yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				System.out.println("enter the name");
				String name = scanner.nextLine();
				String update = "update Student set name = :name where roll_no = :id";
				transaction.begin();
				Query query = manager.createQuery(update);

				query.setParameter("id", roll_no);
				query.setParameter("name", name);
				query.executeUpdate();
				transaction.commit();

			}

			System.out.println("do toy want to update the mobile number (y/n)");
			yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				System.out.println("enter the mobile number");
				long mobile_no = scanner.nextLong();
				String update = "update Student set mobile_no = :mobile_no where roll_no = :id";
				transaction.begin();
				Query query = manager.createQuery(update);

				query.setParameter("id", roll_no);
				query.setParameter("mobile_no", mobile_no);
				query.executeUpdate();
				transaction.commit();
			}

			System.out.println("do toy want to update the standard (y/n)");
			yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				System.out.println("enter the standard");
				String standard = scanner.next();
				String update = "update Student set standard = :standard where roll_no = :id";
				transaction.begin();
				Query query = manager.createQuery(update);

				query.setParameter("id", roll_no);
				query.setParameter("standard", standard);
				query.executeUpdate();
				transaction.commit();
			}

			System.out.println("do toy want to update the DOB (y/n)");
			yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				System.out.println("enter the DOB");
				String DOB = scanner.next();
				String update = "update Student set DOB = :DOB where roll_no = :id";
				transaction.begin();
				Query query = manager.createQuery(update);

				query.setParameter("id", roll_no);
				query.setParameter("DOB", DOB);
				query.executeUpdate();
				transaction.commit();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			manager.close();
			factory.close();

		}

	}

	public void delete() {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a id");
		try {
			int id = sc.nextInt();
			factory = Persistence.createEntityManagerFactory("emp");

			manager = factory.createEntityManager();

			EntityTransaction transaction = manager.getTransaction();

			String delete = "DELETE FROM Student WHERE roll_no = :id";

			transaction.begin();
			Query query = manager.createQuery(delete);

			query.setParameter("id", id);
			 int result = query.executeUpdate();
			 if(result==0)
			 {
				 throw new IdNotFoundException();
			 }
			transaction.commit();

		} catch (IdNotFoundException idnf) {
			// TODO: handle exception
			idnf.getMessage();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			manager.close();
			factory.close();

		}

	}

	
	 

}
