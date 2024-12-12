package com.QuesztionService.Quiz.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuesztionService.Quiz.Bean.AddQuestionsBean;
import com.QuesztionService.Quiz.Bean.SubmitforvalidationBean;
import com.QuesztionService.Quiz.Model.AddQuestionsmodel;
import com.QuesztionService.Quiz.Repo.AddQuestionRepo;

@Service
public class AddQuestionService {
	@Autowired
	AddQuestionRepo addrepo;
	public AddQuestionsmodel savequestions(AddQuestionsmodel add)
	{
		return addrepo.save(add);
	}
public List<AddQuestionsmodel> getquestions()
{
	List<AddQuestionsmodel> list=addrepo.findAll();
	return list;
}

public Optional<List<AddQuestionsmodel>> getquestionsbytitle(String title)
{
	List<AddQuestionsBean> lst = new ArrayList<>();
	/* Optional<AddQuestionsmodel> list=addrepo.findById(1); */
	Optional<List<AddQuestionsmodel>> list=addrepo.getquestions(title);
	/*
	 * for(AddQuestionsmodel bean : list.get()) { AddQuestionsBean addbn = new
	 * AddQuestionsBean(bean); lst.add(addbn); }
	 */
	

	return list;
}
public int validateService(List<SubmitforvalidationBean> SubmitforvalidationBeanobj,String Title)
{
	Optional<List<AddQuestionsmodel>> list=addrepo.getquestions(Title);
	List<AddQuestionsmodel> list1=list.get();
	int Count=0;
	for(int i=0;i<list1.size();i++)
	{
		for(int j=0;j<SubmitforvalidationBeanobj.size();j++)
		{
			
			if(list1.get(i).getQuestion().equals(SubmitforvalidationBeanobj.get(j).getQuestion()))
			{
				if(list1.get(i).getCorrectAnswer().equals(SubmitforvalidationBeanobj.get(j).getAnswer()))
				{
					Count++;
				}
			}
			
		}
		
	}
	
	return Count;
}

}
