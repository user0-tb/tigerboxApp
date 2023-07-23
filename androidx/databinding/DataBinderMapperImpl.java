package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    DataBinderMapperImpl() {
        addMapper((DataBinderMapper) new media.tiger.tigerbox.DataBinderMapperImpl());
    }
}
