package XML2SAX;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Scanner;

import XML2SAX.Article;

public class XML2SAX extends DefaultHandler{

	private String fileName = null;
	private List<Article> list;
	private Article article;
	private String tagName;//节点名称
	
    public XML2SAX(String fileName){
    	this.fileName=fileName;
    	
    }


	public List<Article> getList() {
	        return list;
	    }


	    public void setList(List<Article> list) {
	        this.list = list;
	    }


	    public Article getArticle() {
	        return article;
	    }


	    public void setArticle(Article article) {
	        this.article = article;
	    }


	    public String getTagName() {
	        return tagName;
	    }


	    public void setTagName(String tagName) {
	        this.tagName = tagName;
	    }
	    

	    @Override
	    public void startDocument() throws SAXException {
	        list=new ArrayList<Article>();
	    }
	    
	    //开始解析,标签头
	    @Override
	    public void startElement(String uri, String localName, String qName,
	            Attributes attributes) throws SAXException {
	        if(qName.equals("article")){
	            article=new Article();
	            article.setAuthornum(0);
	            //获取Article节点上的doi属性值
	            article.setDoi(attributes.getValue(0));
	        }
	        else if(qName.equals("journal")){
	        	article.setJcode(attributes.getValue(0));
	        	article.setJshort(attributes.getValue(1));
	        }
	        else if(qName.equals("issue")){
	        	article.setPrintdate(attributes.getValue(0));
	        }
	        else if(qName.equals("arttype")){
	        	article.setType(attributes.getValue(0));
	        }
	        else if(qName.equals("received")){
	        	article.setReceived_date(attributes.getValue(0));
	        }
	        else if(qName.equals("cpyrtdate")){
	        	article.setCopyright_date(attributes.getValue(0));
	        }

	        this.tagName=qName;
	    }
	    
	    @Override
	    public void endElement(String uri, String localName, String qName)
	            throws SAXException {
	        if(qName.equals("article")){
	        	
	        	String temp = article.getDoi()+'\t';
            	temp+=article.getJournal()+'\t';
            	temp+=article.getJcode()+'\t';
            	temp+=article.getJshort()+'\t';
            	temp+=String.valueOf(article.getVolume())+'\t';	            	
            	temp+=article.getIssue()+'\t';
            	temp+=article.getPrintdate()+'\t';
            	temp+=article.getFpage()+'\t';
            	temp+=article.getLpage()+'\t';	            	
            	temp+=article.getSeqno()+'\t';
            	temp+=String.valueOf(article.getPrice())+'\t';	            	
            	temp+=article.getTocsec()+'\t';
            	temp+=article.getArttype()+'\t';
            	temp+=article.getType()+'\t';
            	temp+=article.getTitle()+'\t';
            	
            	int flag=article.getAuthornum();
            	String author="";
            	if(flag!=0){
            		for(int i=0;i<flag;i++){
            			String givenname = article.getGivenname(i);
            			String middlename = article.getMiddlename(i);
            			String surname = article.getSurname(i);

            			if(givenname!=null&&!givenname.substring(givenname.length()-1).equals(".")){
            				givenname+=" ";
            			}
            			if(middlename!=null&&!middlename.substring(middlename.length()-1).equals(".")){
            				middlename+=" ";
            			}
            			if(i<flag-1&&surname!=null){
            				surname+=",";
            			}
            			if(givenname!=null){
            				author+=givenname;
            			}
            			if(middlename!=null){
            				author+=middlename;
            			}
            			if(surname!=null){
            				author+=surname;
            			}
            		}	
            	}
            	else{
            		author=null;
            	}
        		temp+=author+'\t';           		
            	temp+=article.getAff()+'\t';
            	temp+=article.getReceived_date()+'\t';
            	temp+=article.getCopyright_date()+'\t';
            	temp+=article.getCopyright_holder()+'\n';
            	
//        	   System.out.println(temp);
//               System.out.println();
            	
				try {
					
					File file = new File("TXT/"+this.fileName+".txt");
		            BufferedOutputStream bout = null;
		            OutputStream out;
					out = new FileOutputStream(file,true);
					bout = new BufferedOutputStream(out);
		            bout.write(temp.getBytes());
		            bout.flush();
		            
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	             
                
	        }
	        this.tagName=null;
	    }
	    
	    @Override
	    public void endDocument() throws SAXException {
	    }
	    
//	    public static void out(String temp){
//	    	String fileName ;
//	    }
	    
	    @Override
	    public void characters(char[] ch, int start, int length)
	            throws SAXException {
	        if(this.tagName!=null){
	           
	        	String temp=new String(ch,start,length);
	            if(this.tagName.equals("doi")){
	                this.article.setDoi(temp);
	            }
	            else if(this.tagName.equals("journal")){
	            	this.article.setJournal(temp);
	            }
	            else if(this.tagName.equals("volume")){
	            	this.article.setVolume(temp);
	            }
	            else if(this.tagName.equals("issue")){
	            	this.article.setIssue(temp);
	            }
	            else if(this.tagName.equals("fpage")){
	            	this.article.setFpage(temp);
	            }
	            else if(this.tagName.equals("lpage")){
	            	this.article.setLpage(temp);
	            }
	            else if(this.tagName.equals("seqno")){
	            	this.article.setSeqno(temp);
	            }
	            else if(this.tagName.equals("price")){
	            	this.article.setPrice(temp);
	            }
	            else if(this.tagName.equals("tocsec")){
	            	this.article.setTocsec(temp);
	            }
	            else if(this.tagName.equals("arttype")){
	            	this.article.setArttype(temp);
	            }
	            else if(this.tagName.equals("title")){
	            	this.article.setTitle(temp);
	            }
	            else if(this.tagName.equals("givenname")){
	            	int num = this.article.getAuthornum();
	            	this.article.setGivenname(temp, num);
	            }
	            else if(this.tagName.equals("middlename")){
	            	int num = this.article.getAuthornum();
	            	this.article.setMiddlename(temp, num);	
	            	
	            }
	            else if(this.tagName.equals("surname")){
	            	int num = this.article.getAuthornum();
	            	this.article.setSurname(temp, num);
	            	this.article.setAuthornum(num+1);
	            }
	            else if(this.tagName.equals("aff")){
	            	this.article.setAff(temp);
	            }
	            else if(this.tagName.equals("cpyrtholder")){
	            	this.article.setCopyright_holder(temp);
	            }

	         
	        }
	    }
	    
	    @SuppressWarnings("resource")
		public static void main(String[] args) throws IOException {
	    	     
	    	
	    	
	    	SAXParser parser = null;
	    	     System.out.println("输入一个不带后缀的文件名，如PR:");
	    	     Scanner input =new Scanner(System.in);
	    	     String fileName=input.nextLine();//会从控制台读入一个字符串，以回车为标志
	    	     
	    	     File file = new File("TXT/"+fileName+".txt");
	             BufferedOutputStream bout = null;

	              OutputStream out = new FileOutputStream(file,true);
	              bout = new BufferedOutputStream(out);
	              bout.write("doi\tjournal\tjcode\tshort\tvolume\tissue\tprintdate\tfpage\tlpage\tseqno\tprice\ttocsec\tarttype\ttype\ttitle\tauthor\taff\treceived_date\tcopyright_date\tcopyright_holder\n".getBytes());
	              bout.flush();
	      
	              try {
	            //构建SAXParser
	            parser = SAXParserFactory.newInstance().newSAXParser();
	            //实例化  DefaultHandler对象
	            XML2SAX parseXml=new XML2SAX(fileName);
	            //加载资源文件 转化为一个输入流
	            InputStream stream=XML2SAX.class.getClassLoader().getResourceAsStream("Research Data 20150619/aps-data/"+fileName+".xml");
	            //调用parse()方法
	            parser.parse(stream, parseXml);
	            //遍历结果
	          
	            // List<Article> list=parseXml.getList();
	           

	        } catch (ParserConfigurationException e) {
	            e.printStackTrace();
	        } catch (SAXException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }
	    
	
	
}
