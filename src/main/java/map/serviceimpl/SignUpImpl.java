package map.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import map.domain.User;
import map.repository.SignUpRepo;
import map.service.SignUpService;

@Service
@Transactional
public class SignUpImpl implements SignUpService {
	@Autowired
	SignUpRepo signupRepo;

	@Override
	public void save(User user) {
		//
		signupRepo.save(user);
	}

}
