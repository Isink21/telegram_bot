package Isink.user.service;

import Isink.user.entity.TelegramUser;
import Isink.user.repository.TelegramUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserServiceImpl implements TelegramUserService{

    @Autowired
    private TelegramUserRepository telegramUserRepository;

    @Override
    public void save(TelegramUser user) {
        telegramUserRepository.save(user);
    }

    @Override
    public List<TelegramUser> retrieveAllActiveUsers() {
        return telegramUserRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findById(chatId);
    }
}
