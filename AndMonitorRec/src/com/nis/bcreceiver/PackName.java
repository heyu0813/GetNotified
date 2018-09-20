package com.nis.bcreceiver;

public class PackName 
{
	private static String [] packageNames = {
		"com.tencent.news", 		/*0*/
		"com.sohu.newsclient", 		/*1*/
		"com.sina.news",			/*2*/
		"com.ifeng.news2",			/*3*/
		"com.baidu.news",			/*4*/
		"com.ss.android.article.news",		/*5*/
		"net.xinhuamm.mainclient",			/*6*/
		"com.ccdi.news",					/*7*/
		"com.peopledailychina.activity",	/*8*/
		"mnn.Android",						/*AP9*/
		"com.foxnews.android",				/*FoxNews10*/
		"com.cnn.mobile.android.phone",		/*CNN 11*/
		"bbc.mobile.news.ww",				/*BBC 12*/
		"com.wallstreetcn.news",			/*13*/
		"com.netease.newsreader.activity",	/*14*/
		"com.nandu"							/*15*/	
	};
	//"mnn.Android",						/*AP9*/
	//"com.foxnews.android"				/*FoxNews10*/
	//title 16908310, 16908310
	//time_id 16908388, 16908388
	//text_id 16908358, 16908358
	private static String [] newsSource = {
		"��Ѷ����",
		"�Ѻ�����",
		"��������",
		"�������",
		"�ٶ�����",
		"����ͷ��",
		"�����緢��",
		"�����ί",
		"�����ձ�",
		"AP",
		"FoxNews",
		"CNN",
		"BBC",
		"�����ּ���",
		"��������",
		"�϶�"
	};
	//�¼�app��������������ҲҪ����
	private static int [][] title_id2 = {
			{},{2131101133},{},{},{},{2131165281},
			{},{},{},{},{},{},
			{},{},{},{}
	};
	private static int [][] time_id2 = {
			{},{2131101132},{},{},{},{2131165792},
			{},{},{},{},{},{},
			{},{},{},{}
	};
	
	private static int [][] text_id2 = {
			{},{2131101135},{},{},{},{2131165501},
			{},{},{},{},{},{},
			{},{},{},{}
	};
	
	private static int [] CHINA_NEWS = 
	{
		1, 1, 1, 1, 
		1, 1, 1, 1, 
		1, 0, 0, 0,
		0, 1, 1, 1
	};
	//����
	private static int [] title_id = {
		16908310, 2131101138, 16908310, 16908310, 2131624047, 16908310, 
		-1, 16908310, 16908310,	16908310, 16908310,	16908310,
		16908310, 16908310,16908310,16908310
		};
		
	//ʱ��
	private static int [] time_id = {
		16908388, 2131101137, 16908388, 16908388, 2131624135, 16908388, 
		2131427446, 16908388, 16908388,16908388, 16908388,16908388,
		16908388,16908388,16908388,16908388
	};
	//���ı�id,������0��ʾû��������ݵ�id
	private static int [] text_id = {
		16908358, 2131101140, 16908358, 16908358, 2131624131, 16908358, 
		2131427447, 16908358, 16908358,16908358, 16908358,16908358,
		16908358,16908358,16908358,16908358
	};
	
	
	public static boolean isTargetApp(String packName)
	{
		return (getPackIndex(packName) >= 0) ? true : false;
	}
	
	//�ж��Ƿ����ý��
	public static boolean isChina(String packName)
	{
		int nindex = getPackIndex(packName);
		if(nindex != -1)
		{
			return (CHINA_NEWS[nindex] == 1);
		}else
			return false;
	}
	
	private static int getPackIndex(String packName)
	{
		int i = 0;
		int index = -1;
		for(i = 0; i < packageNames.length; i ++)
		{
			if(packName.equals(packageNames[i]))
			{
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	/*
	 * ���ض�Ӧpackagename��������Դ����
	 * */
	public static String getNewsSource(String packName)
	{
		String source = "default";
		int index = getPackIndex(packName);
		if(index >= 0)
			source = newsSource[index];
		
		return source;
	}
	
	private static boolean intEqual(int labelid, int [] array)
	{
		for(int value : array)
		{
			if(labelid == value)
			{
				return true;
			}
		}
		return false;
	}
	
	public static int checkID(String packName, int label_id)
	{
		int id_i = PushMessCache.UNKNOWN_INDEX;
		int index = getPackIndex(packName);
		if(index >= 0)
		{
			if(label_id == title_id[index] || intEqual(label_id,title_id2[index]))
				id_i = PushMessCache.TITLE_INDEX;
			else if(label_id == time_id[index] || intEqual(label_id,time_id2[index]))
				id_i = PushMessCache.TIME_INDEX;
			else if(label_id == text_id[index] || intEqual(label_id,text_id2[index]))
				id_i = PushMessCache.TEXT_INDEX;
		}
		return id_i;
	}
	
	
	
}
