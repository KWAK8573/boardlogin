package com.vision.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.vision.bean.MvcBoard;

public interface MvcBoardDAO {
	public void write(MvcBoard bean);
	public ArrayList<MvcBoard> list();
	public MvcBoard contentView(long bId);
	public void modify(MvcBoard bean);
	public void delete(long bId);
	public MvcBoard reply_view(long bId);
	public void reply(MvcBoard bean);
	public void replyShape(HashMap<String, Integer> map);
	public void upHit(long bId);

}
