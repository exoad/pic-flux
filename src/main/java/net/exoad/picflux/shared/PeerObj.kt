package net.exoad.picflux.shared

abstract class PeerObj<E>
{
	abstract fun acquire():E?
	
	abstract fun compose()
}
