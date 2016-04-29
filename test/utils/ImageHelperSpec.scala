package utils

import play.api.test._
import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO

object ImageHelperSpec extends PlaySpecification  {
	
	"ImageHelperSpec" should {
		"#resize image" in {
			val image = new File("./test/resource/salomo.png")
			val width = 300
			val height = 400
			val imageHelper = new ImageHelper
			imageHelper.resize(image,width,height)
			var bimg:BufferedImage = ImageIO.read(new File("./test/resource/salomo.png"))
			var resizedWidth:Int = bimg.getWidth
			var resizedHeight:Int = bimg.getHeight
			resizedWidth mustEqual 300 
			resizedHeight mustEqual 400 
			}
		"#resizeByWidth image" in {
			val image = new File("./test/resource/salomo.png")
			val width = 500
			val imageHelper = new ImageHelper
			imageHelper.resizeByWidth(image,width)
			var bimg:BufferedImage = ImageIO.read(new File("./test/resource/salomo.png"))
			var resizedWidth:Int = bimg.getWidth
			resizedWidth mustEqual 500 
			}
		"#resizeByHeight image" in {
			val image = new File("./test/resource/salomo.png")
			val height = 400
			val imageHelper = new ImageHelper
			imageHelper.resizeByHeight(image,height)
			var bimg:BufferedImage = ImageIO.read(new File("./test/resource/salomo.png"))
			var resizedHeight:Int = bimg.getHeight
			resizedHeight mustEqual 400 
			}
		"#overlayImage" in {
			//image file define
			var belowImage:File = new File("./test/resource/picture1.png")
			var aboveImage:File = new File("./test/resource/picture2.png")
			var upperLeftPoint:Tuple2[Int, Int] = (0,0)
			var imageHelper = new ImageHelper
			
			//call overlay function
			imageHelper.overlayImage(belowImage:File, aboveImage:File, upperLeftPoint:Tuple2[Int, Int])
			
			//compare belowImage and TempImage's height and width
			var belowImageBuffer:BufferedImage = ImageIO.read(new File("./test/resource/picture1.png"))
			var TempImageBuffer:BufferedImage = ImageIO.read(new File("./test/resource/TempImage.png"))
			val TempImage:File = new File("./test/resource/TempImage.png")
			//check TempImage is exist
			TempImage.exists mustEqual true
			belowImageBuffer.getHeight mustEqual TempImageBuffer.getHeight
			belowImageBuffer.getWidth mustEqual TempImageBuffer.getWidth
			}
		}

		"chrome filter" in {
			var image:File = new File("./test/resource/picture1.png")
			var imageHelper = new ImageHelper
			imageHelper.chrome(image)
			true mustEqual true
		}

		"blur filter" in {
			var image:File = new File("./test/resource/picture1.png")
			var imageHelper = new ImageHelper
			imageHelper.blur(image)
			true mustEqual true
		}

		"colorHalftone filter" in {
			var image:File = new File("./test/resource/picture1.png")
			var imageHelper = new ImageHelper
			imageHelper.colorHalftone(image)
			true mustEqual true
		}

		"edge filter" in {
			var image:File = new File("./test/resource/picture1.png")
			var imageHelper = new ImageHelper
			imageHelper.edge(image)
			true mustEqual true
		}

		"lensFlare filter" in {
			var image:File = new File("./test/resource/picture1.png")
			var imageHelper = new ImageHelper
			imageHelper.lensFlare(image)
			true mustEqual true
		}

		"twirl filter" in {
			var image:File = new File("./test/resource/picture1.png")
			var imageHelper = new ImageHelper
			imageHelper.twirl(image)
			true mustEqual true
		}
}
