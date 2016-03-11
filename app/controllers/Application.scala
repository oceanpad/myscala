package controllers

import play.api._
import play.api.mvc._
import play.api.db._
import play.api.Play.current

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
		case class profile(id:Int, email:String, name:String, pass:String)
  def searchId() = Action{
		var profile1:List[profile] = List.empty[profile]
		DB.withConnection { conn =>
		 val statement = conn.createStatement()
		 val resultSet = statement.executeQuery("SELECT * FROM users")
		 while ( resultSet.next() ) {
			 val id = resultSet.getString("user_id").toInt
			 val user = resultSet.getString("email")
			 val name = resultSet.getString("display_name")
			 val pass = resultSet.getString("password")
			 profile1 =profile1 :+ profile(id,user,name,pass)
		 }		 
		}	
  Ok(profile1.toString)
	}
}
