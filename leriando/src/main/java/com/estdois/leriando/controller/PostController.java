package com.estdois.leriando.controller;

import com.estdois.leriando.entity.Comentario;
import com.estdois.leriando.entity.Post;
import com.estdois.leriando.entity.Usuario;
import com.estdois.leriando.persistence.ComentarioRepository;
import com.estdois.leriando.persistence.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.util.BeanDefinitionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Controller
public class PostController {
    long i,k;
    static List<String> listaDeTipos = null;

    static {
        listaDeTipos = new ArrayList<>();
        listaDeTipos.add("Matemática");
        listaDeTipos.add("Portugues");
        listaDeTipos.add("Inglês");
        listaDeTipos.add("Espanhol");
        listaDeTipos.add("História");
        listaDeTipos.add("Ciências");
        listaDeTipos.add("Geografia");
        listaDeTipos.add("Redação");
    }

    @Autowired
    PostRepository postRepository;
    @Autowired
    ComentarioRepository comentRepository;

    @RequestMapping("/post/mat")
    public String MatPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostMat());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/pt")
    public String PtPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostPt());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/eng")
    public String IngPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostEng());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/esp")
    public String EspPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostEsp());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/hist")
    public String HisPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostHist());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/geo")
    public String GeoPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostGeo());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/Bio")
    public String BioloPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostBiol());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }
    @RequestMapping("/post/rdc")
    public String RedaPosts(Model model, Model models){
        model.addAttribute("posts",postRepository.findPostRedacao());
        models.addAttribute("coments", comentRepository.findComentarios());
        return "ListaDePosts";
    }

    @RequestMapping("/post")
    public String ListTiposPosts(){
        return "listaDeTipos";
    }

    @RequestMapping("/post/asd")
    public String ListarPosts(Model model, Model models){
            model.addAttribute("posts",postRepository.findAll());
            models.addAttribute("coments", comentRepository.findComentarios());

        //List<Post> postcoment = null;
        //postcoment = new ArrayList<>();
        //postcoment.add(postRepository.findAll());
        //model.addAttribute("coments", )
        /*List<Post> listaDePosts = new ArrayList<Post>();
        for ( i = 1; i == postRepository.count(); i++){
            listaDePosts.add(postRepository.findById(i));
        }
                postRepository.findAll();
        for ( i = 1; i == postRepository.count(); i++)
        {   List<Post> listaDePosts = postRepository.findAll();
            for (k = 1; k == comentRepository.count(); k++);
            {   listaDePosts = new ArrayList<>();
                Comentario coment = comentRepository.findById(k);
                if (coment. == ){
                    listaDeTipos.add(coment.getText());
                }
            }
            model.addAttribute("coments", listaDePosts);
            listaDePosts = null;
        }*/
        return "ListaDePosts";
    }

    @GetMapping("/post/add")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("listaDeTipos", listaDeTipos);
        return "postForm";
    }

    @PostMapping("/post/process")
    public String processFrom(@Validated Post post, BindingResult result){
        if (result.hasErrors()){
            return "postForm";
        }
        if (post.getText() != ""){
            postRepository.save(post);
            return "redirect:/post";
        }else{
            return "postForm";
        }
    }

    @PostMapping("/post/{id}")
    public String returPost(){
        return "home";
    }



}
