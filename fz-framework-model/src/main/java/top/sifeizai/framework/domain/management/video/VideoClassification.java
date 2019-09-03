package top.sifeizai.framework.domain.management.video;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: wwy
 * @Date: 2019-09-03 10:24
 */
@Data
@ToString
@Entity
@Table(name="tb_video_classification")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class VideoClassification implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "id",length = 32)
    private String id;
    @Column(name = "parent_id")
    private String parentId;
    @Column(name = "classification_name")
    private String classificationName;
    @Column(name = "classification_grade")
    private String classificationGrade;
    @Column(name = "gen_time")
    private String genTime;
}
