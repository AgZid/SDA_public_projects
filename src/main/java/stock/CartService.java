package stock;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class CartService {
    private Cart cart;


    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void showGoodsInCart() throws DocumentException, IOException, URISyntaxException {
        if (cart.getGoods() == null || cart.getGoods().isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println(cart.getGoods());
            printToPDF();
        }
    }

    public void previewTotalPrice() {
        System.out.println(countTotalPrice());
    }

    public double countTotalPrice() {
        double totalPrice = cart.getGoods().stream()
                .mapToDouble(goodItem -> goodItem.getPrice() * goodItem.getQuantity())
                .summaryStatistics()
                .getSum();

        return (double) Math.round(totalPrice * 100) / 100;
    }

    public void addGoodsToCart(String goodName, int goodQuantity, double goodPrice) {
        GoodItem goodItemToAdd = new GoodItem(goodName, goodQuantity, goodPrice);

        if (cart.getGoods() == null) {
            List<GoodItem> goodsToAdd = new ArrayList<>();
            goodsToAdd.add(goodItemToAdd);
            cart.setGoods(goodsToAdd);
        } else {
            cart.getGoods().add(goodItemToAdd);
        }

        System.out.println(goodName + " are added");
    }

    public boolean isGoodInCart(String userEnteredGood) {
        if (cart.getGoods() == null) {
            return false;
        }
        return cart.getGoods().stream().anyMatch(goodItem -> goodItem.getName().equalsIgnoreCase(userEnteredGood));
    }

    public void removeGoodsFromCart(String name) {
        cart.getGoods().removeIf(goodItem -> name.equalsIgnoreCase(goodItem.getName()));
    }

    public void printToPDF() throws IOException, DocumentException, URISyntaxException {

        Path path = Paths.get(ClassLoader.getSystemResource("Smile.png").toURI());

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("SmileCart.pdf"));

        document.open();

        Font headingFont = FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 16, BaseColor.DARK_GRAY);
        Font smallBold = FontFactory.getFont(FontFactory.TIMES_ITALIC, 8, BaseColor.LIGHT_GRAY);

        Paragraph paragraph1 = new Paragraph();
        addEmptyLine(paragraph1, 1);

        Image img = Image.getInstance(path.toAbsolutePath().toString());
        document.add(img);

        Paragraph paragraph2 = new Paragraph("Shopping Cart", headingFont);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(paragraph2, 1);
        document.add(paragraph2);

        Paragraph paragraph3 = new Paragraph("Shopping list generated on" + new Date(), smallBold);
        addEmptyLine(paragraph3, 3);
        document.add(paragraph3);

        PdfPTable table = new PdfPTable(4);
        addTableHeader(table);
        cart.getGoods().forEach(goodItem -> addRows(table, goodItem));
        addTotalRow(table);
        document.add(table);

        Paragraph paragraph4 = new Paragraph();
        addEmptyLine(paragraph4, 3);
        paragraph4.add(new Paragraph("Thank you :)", smallBold));
        addEmptyLine(paragraph4, 1);
        paragraph4.add(new Paragraph("If you have any questions about this invoice, please contact", smallBold));
        paragraph4.add(new Paragraph("Phone no.: 8585858585, e-mail: smile@smile.com", smallBold));

        document.add(paragraph4);

        document.close();
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Item name", "Unit price", "Quantity", "Amount")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, GoodItem goodItem) {
        table.addCell(goodItem.getName());
        table.addCell(String.valueOf(goodItem.getPrice()));
        table.addCell(String.valueOf(goodItem.getQuantity()));
        table.addCell(String.valueOf((double) Math.round(goodItem.getQuantity() * goodItem.getPrice() * 100) / 100));
    }

    private void addTotalRow(PdfPTable table) {

        table.addCell("");
        table.addCell("");

        Font totalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("Total amount:", totalFont));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(horizontalAlignCell);

        PdfPCell totalPrice = new PdfPCell(new Phrase(String.valueOf(countTotalPrice()), totalFont));

        table.addCell(totalPrice);

    }

    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
