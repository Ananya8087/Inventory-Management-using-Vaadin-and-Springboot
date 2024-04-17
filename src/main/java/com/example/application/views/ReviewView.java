package com.example.application.views;

import com.example.application.data.entity.Review;
import com.example.application.data.service.ReviewService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("reviews")
public class ReviewView extends VerticalLayout {
    private final ReviewService reviewService;
    private Grid<Review> grid = new Grid<>(Review.class);

    public ReviewView(ReviewService reviewService) {
        this.reviewService = reviewService;
        addClassName("review-view");
        setSizeFull();
        configureGrid();
        addBackButton();
        add(grid);
        updateList();
    }

    private void configureGrid() {
        grid.addClassName("review-grid");
        grid.setSizeFull();
        grid.setColumns("id", "productId", "rating", "comment", "createdDate");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private void updateList() {
        grid.setItems(reviewService.findAllReviews());
    }
    private void addBackButton() {
        Button backButton = new Button("Back", event -> 
            UI.getCurrent().navigate("master-detail")
        );
        backButton.addClassName("back-button"); // Optionally add styling class
        add(backButton);
    }
}
