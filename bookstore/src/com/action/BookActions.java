package com.action;

import com.entity.Book;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by luxu on 2017/8/12.
 */
public class BookActions extends ActionSupport{
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String author;
    private String category;
    private int price;
    private BookService bookService;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public String getAllBooks() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response= ServletActionContext.getResponse();
        List<Book> booklist=bookService.getAllBooks();
        String result= JSONArray.fromObject(booklist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String getBookDetail() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        HttpServletRequest request=ServletActionContext.getRequest();
        int bookid=Integer.parseInt(request.getParameter("id"));
        Book book=bookService.getBookById(bookid);
        JSONObject results = new JSONObject();
        results.put("success", true);
        results.put("id",String.valueOf(book.getId()));
        results.put("title",book.getTitle());
        results.put("author",book.getAuthor());
        results.put("price", String.valueOf(book.getPrice()));
        results.put("category",book.getCategory());
        response.getWriter().print(results.toString());
        return null;
    }

    public String getBookByTitle() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response=ServletActionContext.getResponse();
        HttpServletRequest request=ServletActionContext.getRequest();
        String title=request.getParameter("title");
        List<Book>booklist=bookService.getBookByTitle(title);
        String result=JSONArray.fromObject(booklist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String getBookByCategory() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response=ServletActionContext.getResponse();
        HttpServletRequest request=ServletActionContext.getRequest();
        String category1=request.getParameter("category");
        List<Book>booklist=bookService.getBookByCategory(category1);
        String result=JSONArray.fromObject(booklist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String getBookByID() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response=ServletActionContext.getResponse();
        HttpServletRequest request=ServletActionContext.getRequest();
        int bookid=0;
        try{
            bookid=Integer.parseInt(request.getParameter("bookid").toString());
        }
        catch(Exception e){
            return null;
        }
        List<Book>booklist=bookService.getBookByID(bookid);
        String result=JSONArray.fromObject(booklist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String getCartDetail() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        int total=0;
        JSONArray cartjson = new JSONArray();
        Map<String, Object> session = ActionContext.getContext().getSession();
        @SuppressWarnings("unchecked")
        Map<Integer,Integer> cart= (Map<Integer, Integer>) session.get("cart");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
            int bookid=entry.getKey();
            int amount=entry.getValue();
            Book book=bookService.getBookById(bookid);
            JSONObject tmp = new JSONObject();
            int tmp_price=book.getPrice();
            total=total+tmp_price;
            tmp.put("id", book.getId());
            tmp.put("title", book.getTitle());
            tmp.put("author", book.getAuthor());
            tmp.put("price", book.getPrice());
            tmp.put("category",book.getCategory());
            tmp.put("amount", String.valueOf(amount));
            cartjson.add(tmp);
        }
        response.getWriter().print(cartjson.toString());
        return null;
    }

    public String addBook() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        Book book=new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setPrice(price);
        bookService.addBook(book);
        JSONObject results = new JSONObject();
        results.put("success", true);
        response.getWriter().print(results.toString());
        return null;
    }

    public String updateBook() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        Book book=bookService.getBookById(id);
        book.setPrice(price);
        book.setAuthor(author);
        book.setCategory(category);
        book.setTitle(title);
        bookService.updateBook(book);
        JSONObject results = new JSONObject();
        results.put("success", true);
        response.getWriter().print(results.toString());
        return null;
    }

    public String deleteBook() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        Book book=bookService.getBookById(id);
        bookService.deleteBook(book);
        JSONObject results = new JSONObject();
        results.put("success", true);
        response.getWriter().print(results.toString());
        return null;
    }
}
