package umc.spring.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionNotice is a Querydsl query type for MissionNotice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionNotice extends EntityPathBase<MissionNotice> {

    private static final long serialVersionUID = -477680931L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionNotice missionNotice = new QMissionNotice("missionNotice");

    public final QAlarm alarm;

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QMissionNotice(String variable) {
        this(MissionNotice.class, forVariable(variable), INITS);
    }

    public QMissionNotice(Path<? extends MissionNotice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionNotice(PathMetadata metadata, PathInits inits) {
        this(MissionNotice.class, metadata, inits);
    }

    public QMissionNotice(Class<? extends MissionNotice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.alarm = inits.isInitialized("alarm") ? new QAlarm(forProperty("alarm"), inits.get("alarm")) : null;
    }

}

