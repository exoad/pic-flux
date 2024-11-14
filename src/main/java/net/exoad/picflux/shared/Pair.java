package net.exoad.picflux.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Pair<A,B>
{
	private A first;
	private B second;
	
	public Pair(A first,B second)
	{
		this.first =first;
		this.second=second;
	}
}
