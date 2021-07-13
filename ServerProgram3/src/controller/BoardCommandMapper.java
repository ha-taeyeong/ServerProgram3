package controller;

import command.BoardCommand;
import command.DeleteBoardCommand;
import command.GoInsertBoardCommand;
import command.InsertBoardCommand;
import command.InsertReplyCommand;
import command.SelectBoardByNoCommand;
import command.SelectBoardListCommand;
import command.UpdateBoardHitCommand;

public class BoardCommandMapper {
	private static BoardCommandMapper instance = new BoardCommandMapper();
	private BoardCommandMapper() {}
	public static BoardCommandMapper getInstance() {
		if (instance == null) {
			instance = new BoardCommandMapper();
		}
		return instance;
	}
	
	public BoardCommand getCommand(String cmd) {
		BoardCommand command = null;
		switch (cmd) {
		case "selectBoardList.do":
			command = new SelectBoardListCommand();
			break;
		
		case "selectBoardByNo.do":
			command = new SelectBoardByNoCommand();
			break;
		
		case "goInsertBoard.do":
			command = new GoInsertBoardCommand();
			break;
		
		case "insertBoard.do":
			command = new InsertBoardCommand();
			break;
		
		case "deletBoard.do":
			command = new DeleteBoardCommand();
			break;
		
		case "updateBoardHit.do":
			command = new UpdateBoardHitCommand();
			break;
		
		case "insertReply.do":
			command = new InsertReplyCommand();
			break;
		}
		return command;
	}
}
