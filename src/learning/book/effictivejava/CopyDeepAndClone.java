package learning.book.effictivejava;

import java.awt.HeadlessException;

import SelfUtil.Debug;

public class CopyDeepAndClone implements Cloneable{
	public Head head;
	public CopyDeepAndClone(Head head){
		this.head = head;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		CopyDeepAndClone newBody = (CopyDeepAndClone)super.clone();
		newBody.head = (Head)head.clone();
		return newBody;
	}
	
	private static class Head implements Cloneable{
		public Face face;
		
		public Head(Face face) {
			this.face = face;
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}
	
	private static class Face{
		
	}
	
	public static void main(String[] args) throws CloneNotSupportedException{
		CopyDeepAndClone body = new CopyDeepAndClone(new Head(new Face()));
		
		CopyDeepAndClone body1 = (CopyDeepAndClone)body.clone();
		
		Debug.print("body == body1 : "+(body == body1));
		
		Debug.print("body.head == body1.head:"+(body.head == body1.head));
		
		Debug.print("body.head.face == body1.head.face:"+(body.head.face == body1.head.face));
	}
}
