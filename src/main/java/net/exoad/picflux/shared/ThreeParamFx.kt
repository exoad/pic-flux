package net.exoad.picflux.shared

fun interface ThreeParamFx<R , A , B , C>
{
	fun call(a:A? , b:B? , c:C?):R?
}
