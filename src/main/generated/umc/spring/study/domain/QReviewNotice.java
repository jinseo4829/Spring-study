package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewNotice is a Querydsl query type for ReviewNotice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewNotice extends EntityPathBase<ReviewNotice> {

    private static final long serialVersionUID = 438847959L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewNotice reviewNotice = new QReviewNotice("reviewNotice");

    public final umc.spring.study.domain.common.QBaseEntity _super = new umc.spring.study.domain.common.QBaseEntity(this);

    public final QAlarm alarm;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewNotice(String variable) {
        this(ReviewNotice.class, forVariable(variable), INITS);
    }

    public QReviewNotice(Path<? extends ReviewNotice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewNotice(PathMetadata metadata, PathInits inits) {
        this(ReviewNotice.class, metadata, inits);
    }

    public QReviewNotice(Class<? extends ReviewNotice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alarm = inits.isInitialized("alarm") ? new QAlarm(forProperty("alarm"), inits.get("alarm")) : null;
    }

}

