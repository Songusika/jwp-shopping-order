package cart.domain.point;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
class PointTest {

    @Test
    void 포인트는_음수이면_예외를_발생한다() {
        // given
        Long point = -1L;

        // expect
        assertThatThrownBy(() -> new Point(point))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("포인트는 최소 0 포인트 이상이어야합니다.");
    }

    @Test
    void 포인트는_다른_포인트를_받아_더할_수_있다() {
        // given
        final Point point = new Point(10L);

        // when
        final Point result = point.add(new Point(30L));

        // then
        assertThat(result.getPoint()).isEqualTo(40L);
    }

    @Test
    void 포인트는_다른_포인트를_받아_뺄_수_있다() {
        // given
        final Point point = new Point(30L);

        // when
        final Point result = point.subtract(new Point(10L));

        // then
        assertThat(result.getPoint()).isEqualTo(20);
    }

    @Test
    void 포인트는_다른_포인트보다_더_큰지_검사할_수_있다() {
        // given
        final Point point = new Point(30L);

        // when
        final boolean result = point.isMoreThan(new Point(10L));

        // then
        assertThat(result).isTrue();
    }
}
