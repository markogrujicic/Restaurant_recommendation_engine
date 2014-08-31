package dll;

public class MemberDoubleLinkedList {
	private Object object;
	private Double coefficient;

	private MemberDoubleLinkedList nextMember;
	private MemberDoubleLinkedList previousMember;

	public MemberDoubleLinkedList(Object obj,MemberDoubleLinkedList nextMember,MemberDoubleLinkedList previousMember,Double coefficient) {
		this.object=obj;
		this.nextMember=nextMember;
		this.previousMember=previousMember;
		this.coefficient=coefficient;
	}
	public Double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public MemberDoubleLinkedList getNextMember() {
		return nextMember;
	}
	public void setNextMember(MemberDoubleLinkedList nextMember) {
		this.nextMember = nextMember;
	}
	public MemberDoubleLinkedList getPreviousMember() {
		return previousMember;
	}
	public void setPreviousMember(MemberDoubleLinkedList previousMember) {
		this.previousMember = previousMember;
	}
	@Override
	public String toString() {
		return "object=" + object + ", \n coefficient=" +  coefficient ;
	}

}