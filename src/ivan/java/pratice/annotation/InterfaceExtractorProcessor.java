package ivan.java.pratice.annotation;

import java.util.Set;

/**
 * Sample Annotation processor
 */

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("ivan.java.pratice.annotation.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class InterfaceExtractorProcessor extends AbstractProcessor
{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
	{

		for (final Element element : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
			if (element instanceof TypeElement) {
				
			}
		}
		return false;
	}

}
