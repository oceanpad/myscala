package utils

import play.mvc.Http.MultipartFormData.FilePart

import java.io.File
import java.io.FileInputStream
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import com.sksamuel.scrimage._
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.AwtImage
import com.sksamuel.scrimage.Image
import scala.util.Random

class ImageHelper {
	
	def resizeByWidth(imageFile:File, width:Int):File = {
		val imageInputStream = new FileInputStream(imageFile)
		Image.fromStream(imageInputStream).resizeToWidth(width).output(imageFile)
	}
	def resizeByHeight(imageFile:File, height:Int):File = {
		val imageInputStream = new FileInputStream(imageFile)
		Image.fromStream(imageInputStream).resizeToHeight(height).output(imageFile)
	}
	def resize(imageFile:File,width:Int ,height:Int):File = {
		val imageInputStream = new FileInputStream(imageFile)
		Image.fromStream(imageInputStream).resizeTo(width,height).output(imageFile)
	}
	
	def scale(imageFile:File,width:Int ,height:Int):File = {
		val imageInputStream = new FileInputStream(imageFile)
		Image.fromStream(imageInputStream).scaleTo(width,height).output(imageFile)
	}
	
	def overlayImage(belowImage:File, aboveImage:File, upperLeftPoint:Tuple2[Int, Int]):File = {
		val belowLay = new FileInputStream(belowImage)
		val aboveLay:AwtImage = new AwtImage(ImageIO.read(aboveImage))
		val TempImage = new File("./test/resource/TempImage.png")
		val x = upperLeftPoint._1
		val y = upperLeftPoint._2
		Image.fromStream(belowLay).overlay(aboveLay, x, y).output(TempImage)
	}

	def chrome(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File("./test/resource/TempImage.png")
    Image.fromStream(imageInputStream).filter(ChromeFilter()).output(tempImage)
	}

	def blur(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(BlurFilter).output(tempImage)
	}

	def colorHalftone(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(ColorHalftoneFilter()).output(tempImage)
	}

	def edge(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(EdgeFilter).output(tempImage)
	}

	def lensFlare(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(LensFlareFilter).output(tempImage)
	}
	
	def twirl(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(TwirlFilter(250)).output(tempImage)
	}

	def oil(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(OilFilter()).output(tempImage)
	}

	def invert(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
    Image.fromStream(imageInputStream).filter(InvertFilter).output(tempImage)
	}

	def pointillizeSquare(origin:File):File = {
		val imageInputStream = new FileInputStream(origin)
		val fileName = "/tmp/" + Random.alphanumeric(32) + ".png"
		val tempImage = new File(fileName)
		import scala.util.Random
		import com.sksamuel.scrimage.filter.PointillizeGridType.{ Triangular, Octangal, Hexagonal, Square }
		val random:Int = new Random().nextInt(5)
		random match {
			case 1 => Image.fromStream(imageInputStream).filter(PointillizeFilter(Square)).output(tempImage)
			case 2 => Image.fromStream(imageInputStream).filter(PointillizeFilter(Hexagonal)).output(tempImage)
			case 3 => Image.fromStream(imageInputStream).filter(PointillizeFilter(Octangal)).output(tempImage)
			case _ => Image.fromStream(imageInputStream).filter(PointillizeFilter(Triangular)).output(tempImage)
		}
	}
  
}
