package br.com.claudemirojr.telegram.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SuppressWarnings("deprecation")
@RestController
@RequestMapping("/teste")
public class TestController extends TelegramLongPollingBot {
	
	
	@Value("${telegram.username}")
	private String telegramUsername;
	
	@Value("${telegram.token}")
	private String telegramToken;

	
	@Value("${telegram.chatid}")
	private String telegramChatId;

	
	@GetMapping("/{mensagem}")
	public String getTeste(@PathVariable("mensagem") String mensagem) {

		Long chatId = Long.parseLong(this.telegramChatId);
		String response = "Mensagem recebida: " + mensagem;
		try {
			execute(new SendMessage(chatId.toString(), response));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		return "Miro";
	}

	@Override
	public String getBotUsername() {
		return this.telegramUsername;
	}

	@Override
	public String getBotToken() {
		return this.telegramToken;
	}

	@Override
	public void onUpdateReceived(Update update) {
		/*
		 * if (update.hasMessage() && update.getMessage().hasText()) { String
		 * messageText = update.getMessage().getText(); Long chatId =
		 * update.getMessage().getChatId(); // Process the message and generate a
		 * response String response = "Mensagem recebida: " + messageText; // Send the
		 * response back to the user try { execute(new SendMessage(chatId.toString(),
		 * response)); } catch (TelegramApiException e) { e.printStackTrace(); } }
		 */
	}

}
