package cn.kk.customview.utils;

import android.content.Context;
import cn.kk.customview.R;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

// 1. 告诉 JUnit 要使用 MockitoJUnitRunner
@RunWith(MockitoJUnitRunner.class)
public class SystemUtilTest extends TestCase {
    private static final String APP_NAME = "cn.kk.custome";

    // 2. 添加注解 Mock
    @Mock
    Context mContext; // 3. 标注模拟对象
    @Test
    public void testGetAppName() {
        // 4. when.thenReturn 逻辑. when() 里面要和 SystemUtil.getAppName() 里的逻辑一样，
        // thenReturn() 里面是预期返回值
        when(mContext.getString(R.string.app_name)).thenReturn(APP_NAME);

        assertEquals(APP_NAME, SystemUtil.getAppName(mContext));
    }
}