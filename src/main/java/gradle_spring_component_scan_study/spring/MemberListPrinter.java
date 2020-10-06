package gradle_spring_component_scan_study.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("listPrinter")
public class MemberListPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;

	public MemberListPrinter() {

	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Autowired
	public void setMemberPrinter(MemberSummaryPrinter printer) {
		this.printer = printer;
	}

}