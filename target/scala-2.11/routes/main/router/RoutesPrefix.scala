
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/haiyang/gitHub/myscala/conf/routes
// @DATE:Sat Feb 27 00:59:22 SGT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
