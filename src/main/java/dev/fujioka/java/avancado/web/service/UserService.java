package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements CrudInterface<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(User entity) {
        return Optional.of(userRepository.save(entity));
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public long count() {
        return userRepository.count();
    }
    
    public List<User> acharUserByFirstName(String firstName){
    	return userRepository.buscarUsuarioPorPrimeiroNome(firstName);
    }
    
    public List<User> acharUserBySubstringFirstName(String string){
    	return userRepository.buscarUsuarioPorSubstringPrimeiroNome(string);
    }
    public List<User> acharUserByLastName(String lastName){
    	return userRepository.buscarUsuarioPorSobreNome(lastName);
    }
    
    public List<User> acharUserBySubstringLastName(String string){
    	return userRepository.buscarUsuarioPorSubstringSobreNome(string);
    }
    
    public List<User> acharUserByPassword(String password){
    	return userRepository.buscarUsuarioPorSenha(password);
    }
    
    public List<User> acharLuis(){
    	return userRepository.procurar();
    }
}
