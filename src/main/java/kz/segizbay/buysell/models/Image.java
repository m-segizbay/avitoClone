package kz.segizbay.buysell.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "originalFileName")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "contentType")
    private String contentType;

    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;

    @Lob
    @Column(name = "bytes", columnDefinition = "LONGBLOB")
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;

    public boolean isPreviewImage() {
        return this.isPreviewImage;
    }

    public void setPreviewImage(boolean isPreviewImage) {
        this.isPreviewImage = isPreviewImage;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Image;
    }

}
