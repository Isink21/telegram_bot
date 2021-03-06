package Isink.user.service;

import Isink.user.entity.TelegramUser;
import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    void save(TelegramUser user);

    List<TelegramUser> retrieveAllActiveUsers();

    Optional<TelegramUser> findByChatId(String chatId);

}