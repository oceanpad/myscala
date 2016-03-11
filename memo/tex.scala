def fac(x:Int) ={
	var r:Long =1
	for (i <- 1 to x) r =r*i
	r
}

def test(x:Int)={
	val xxx =	if (x >0) 1 else (if(x==0) 0 else -1)
	xxx
}
