package controllers

import play.api._
import play.api.mvc._
import play.api.db._
import play.api.Play.current

import java.io.File
import scala.util.Random

import utils.ImageHelper

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
	
	def upload = Action(parse.multipartFormData) { request =>
		request.body.file("picture").map { picture =>
			val filename = picture.filename
			val contentType = picture.contentType
			val getedFile:File = picture.ref.moveTo(new File(s"/tmp/picture/$filename"))
			val resultImage = convertImage(getedFile)
			Ok(org.apache.commons.io.FileUtils.readFileToByteArray(resultImage)).as("image/jpeg")
		}.getOrElse {
			Redirect(routes.Application.index).flashing(
				"error" -> "Missing file")
		}
	}

	def convertImage(image:File):File = {
		val random:Int = new Random().nextInt(10)
		random match {
			case 1 => new ImageHelper().twirl(image)
			case 2 => new ImageHelper().chrome(image)
			case 3 => new ImageHelper().blur(image)
			case 4 => new ImageHelper().colorHalftone(image)
			case 5 => new ImageHelper().edge(image)
			case 6 => new ImageHelper().lensFlare(image)
			case 7 => new ImageHelper().oil(image)
			case 8 => new ImageHelper().invert(image)
			case 9 => new ImageHelper().pointillizeSquare(image)
			case _ => new ImageHelper().pointillizeSquare(image)

		}

	}
}
