package chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
//	@GetMapping
//	public String form(Model model) {
//		
//		List<Question> questions = createQuestions();
//		
//		model.addAttribute("questions", questions);
//		
//		return "survey/form";
//	}
	// surveyController model에 데이터를 저장 
	// 결과를 보여줄 view 이름 반환하지만
	
	// 다른 방법을(ModelAndView) 보여주면
	//(Dispatcher 동작방식을 설명하면서 설명했었음) = HandlerAdapter가 하는일이 없게 하는 방식
	@GetMapping
	public ModelAndView form() {
		List<Question> questions = createQuestions();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/form");
		
		return mav;
		// 반환하는 건 String이 아니라 ModelAndView로 데이터타입 수정하면됨
	}
	
	private List<Question> createQuestions(){
		List<String> job = new ArrayList<>();
		job.add("서버");
		job.add("프론트");
		job.add("풀스택");
		
		List<String> tool = new ArrayList<>();
		tool.add("Eclipse");
		tool.add("Intellij");
		tool.add("VSCode");
		
		Question q1 = new Question("당신의 역할은 무엇입니까?", job);
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", tool);
		Question q3 = new Question("하고싶은 말이 있으신가요?", null);
		
//		List<Question> questions = new ArrayList<>();
//		questions.add(q1);
//		questions.add(q2);
//		questions.add(q3);
//		return questions;
		
		// 위 코드 대신 으로 아래 코드를 사용하면 조금더 편해짐
		
		return Arrays.asList(q1, q2, q3);
	}
	
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData ansData) {
		return "survey/submitted";
	}
	
	
}
