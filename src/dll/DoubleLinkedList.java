package dll;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList {
	private MemberDoubleLinkedList firstMember;

	public MemberDoubleLinkedList getFirstMember() {
		return firstMember;
	}


	public DoubleLinkedList() {
		this.firstMember=null;
	}


	public void insertMember(Object obj,Double coefficient){
		if (obj!=null && firstMember==null){

			firstMember= new MemberDoubleLinkedList(obj,null,null,coefficient);
			firstMember.setNextMember(null);
			firstMember.setPreviousMember(null);
		}
		else {
			if (coefficient<firstMember.getCoefficient()){
				MemberDoubleLinkedList member= new MemberDoubleLinkedList(obj, null, null,coefficient);
				member.setNextMember(firstMember);
				firstMember.setPreviousMember(member);
				firstMember=member;
			}else{
				if(firstMember.getNextMember()==null){
					MemberDoubleLinkedList member= new MemberDoubleLinkedList(obj, null, null,coefficient);
					member.setPreviousMember(firstMember);
					firstMember.setNextMember(member);
				}else{
					MemberDoubleLinkedList pom=firstMember.getNextMember();
					while(coefficient>=pom.getCoefficient() && pom.getNextMember()!=null)
					{
						pom=pom.getNextMember();
					}
					if(pom.getNextMember()==null && coefficient>=pom.getCoefficient()){
						MemberDoubleLinkedList member= new MemberDoubleLinkedList(obj, null, null,coefficient);
						member.setPreviousMember(pom);
						pom.setNextMember(member);

					}else{
						MemberDoubleLinkedList member= new MemberDoubleLinkedList(obj, null, null,coefficient);
						member.setNextMember(pom);
						member.setPreviousMember(pom.getPreviousMember());
						member.getPreviousMember().setNextMember(member);
						pom.setPreviousMember(member);

					}
				}
			}
		}
	}

	public List<MemberDoubleLinkedList> getBestFive(){
		List<MemberDoubleLinkedList> list= new ArrayList<MemberDoubleLinkedList>();
		MemberDoubleLinkedList member=firstMember;
		while(member.getNextMember()!=null){
			member= member.getNextMember();
		}
		if(member.getPreviousMember()==null){
			list.add(member);
		}
		else{
			for (int i = 0; i < 5; i++) {
				if(member!=null){
					list.add(member);
					member= member.getPreviousMember();
				}
			}
		}
		return list;
	}
}

