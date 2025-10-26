package com.example.samuraitravel.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.samuraitravel.entity.Faq;
import com.example.samuraitravel.service.FaqService;

@Controller
public class FaqController {

    private final FaqService faqService;

    // コンストラクタインジェクション
    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

    /**
     * FAQ一覧ページの表示
     * 検索キーワードとページ番号を受け取り、FAQデータを取得してビューに渡す
     */
    @GetMapping("/faqs")
    public String index(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "page", defaultValue = "0") int page,
            Model model) {

        // 1ページあたりの表示件数を5件に設定
        PageRequest pageable = PageRequest.of(page, 5);

        Page<Faq> faqs;

        // キーワード検索がある場合とない場合で処理を分岐
        if (keyword != null && !keyword.trim().isEmpty()) {
            faqs = faqService.findAllFaqs(keyword, pageable);
        } else {
            faqs = faqService.getAllFaqs(pageable);
        }

        // ビューにデータを渡す
        model.addAttribute("faqs", faqs);
        model.addAttribute("keyword", keyword);

        // Thymeleafテンプレートのパス
        return "user/faq";
    }
}
